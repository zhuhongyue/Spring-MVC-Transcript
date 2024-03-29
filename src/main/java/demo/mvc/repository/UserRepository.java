package demo.mvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import demo.mvc.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT x FROM User x WHERE x.name LIKE :name% ORDER BY x.id", countQuery = "SELECT COUNT(x) FROM User x WHERE x.name LIKE :name%")	
	Page<User> findByNameLike(@Param("name") String name, Pageable page);
	
	
	@Query(value =
			//"UPDATE  User x SET  x.birth = (SELECT Var(birth) FROM User) WHERE  x.name = 'Average' "+
			"SELECT x FROM User x ORDER BY x.id",
			countQuery = "SELECT COUNT(x) FROM User x ")	
	Page<User> get_var(Pageable page);
	
}
