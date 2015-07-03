package demo.mvc.service;

import java.util.Date;
import java.util.Iterator;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mvc.exception.ResourceNotFoundException;
import demo.mvc.model.User;
import demo.mvc.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    protected UserRepository userRepository;

    @Inject
    protected PasswordEncoder passwordEncoder;

    @Override
    public void save(User user, String rawPassword) {

		System.out.println("save!?\n");
        //String password = passwordEncoder.encode(rawPassword);
        //if(!password.isEmpty())
        user.setPassword("o");

        Date now = new DateTime().toDate();
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(now);
        }

		System.out.println("update!?\n");
        user.setUpdatedAt(now);
		System.out.println("setupdate!?\n");
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(Integer id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new ResourceNotFoundException("User [id=" + id
                    + "] is not found.");
        }
        System.out.println("USERSERVICE:findone\n");
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findByNameLike(String name, Pageable pageable) {
        String query = name; // TODO escape
        Page<User> page = userRepository.findByNameLike(query, pageable);
        Iterator<User> intr = page.iterator();
        User intrkey;
        int sum = 0;
        int count = 0;
        while(intr.hasNext()){
        	count++;
        	sum += intr.next().getBirth();
        }
        sum=sum/count;
        System.out.println("USERSERVICEIMP:sum:"+sum);
        System.out.println("USERSERVICEIMP:count:"+count);
        intr = page.iterator();
        while(intr.hasNext()){
        	intrkey = intr.next();
        	if(intrkey.getName().equals("Average")){
        		intrkey.setBirth(sum);
        		System.out.println("USERSERVICEIMP:get -> average:" + intrkey.getBirth() );
        	}
        	System.out.println(intrkey.getName());
        }
        System.out.println("first step complete");
        intr = page.iterator();
        double v=0;
        while(intr.hasNext()){
        	intrkey = intr.next();
        	v+=(intrkey.getBirth()-sum) ^ 2;
        }
        v=v/sum;
        intr = page.iterator();
        while(intr.hasNext()){
        	intrkey = intr.next();
        	if(intrkey.getName().equals("Average")){
        		intrkey.setPassword(String.valueOf(v));
        		System.out.println("USERSERVICEIMP:get -> VAR:" + intrkey.getEmail());
        	}
        	System.out.println(intrkey.getName());
        }
        System.out.println("second step complete");
        return page;
    }

    @Override
    public void delete(User user) {
    	System.out.println("delete from the reporsitory!?\n");
    	userRepository.delete(user);
        
    }
    
    @Override
    @Transactional(readOnly = true)
	public Page<User> get_var( Pageable pageable){
    	System.out.println("getvar\n");
    	Page<User> page = userRepository.get_var(pageable);
    	 Iterator<User> intr = page.iterator();
         User intrkey;
         int sum = 0;
         int count = 0;
         while(intr.hasNext()){
         	count++;
         	sum += intr.next().getBirth();
         }
         sum=sum/count;
         System.out.println("USERSERVICEIMP:sum:"+sum);
         System.out.println("USERSERVICEIMP:count:"+count);
         intr = page.iterator();
         while(intr.hasNext()){
         	intrkey = intr.next();
         	if(intrkey.getName().equals("Average")){
         		intrkey.setBirth(sum);
         		System.out.println("USERSERVICEIMP:get -> average:" + intrkey.getBirth() );
         	}
         	System.out.println(intrkey.getName());
         }
         System.out.println("first step complete");
         intr = page.iterator();
         double v=0;
         while(intr.hasNext()){
         	intrkey = intr.next();
         	v+=(intrkey.getBirth()-sum) ^ 2;
         }
         v=v/sum;
         intr = page.iterator();
         while(intr.hasNext()){
         	intrkey = intr.next();
         	if(intrkey.getName().equals("Average")){
         		intrkey.setPassword(String.valueOf(v));
         		System.out.println("USERSERVICEIMP:get -> VAR:" + intrkey.getEmail());
         	}
         	System.out.println(intrkey.getName());
         }
         System.out.println("second step complete");
    	return page;
    }

}
