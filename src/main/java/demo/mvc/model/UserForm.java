package demo.mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Set;
import java.lang.Object;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm implements Serializable {
	/**
	 * Validation group for create user
	 */
	public static interface UserCreateGroup {
		
	}

	/**
	 * Validation group for update user
	 */
	public static interface UserUpdateGroup {
		
	}

	/**
	 * Validation group for delete user
	 */
	public static interface UserDeleteGroup {
		
	}

	
	/**
	 * serial version uid.
	 */
	private static final long serialVersionUID = 1L;

	@Null(groups = { UserCreateGroup.class })
	@NotNull(groups = { UserUpdateGroup.class, UserDeleteGroup.class })
	@Min(0)
	private Integer id;

	@Null(groups = { UserDeleteGroup.class })
	@NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
	@Size(min = 1, max = 20)
	private String name;

	@Null(groups = { UserDeleteGroup.class })
	@NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
	private Integer email;

	@Null(groups = { UserDeleteGroup.class })
	@NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
	public Integer birth;

	@Null(groups = { UserDeleteGroup.class })
	@NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
	@Size(min = 0, max = 30)
	private String password;

	@Null(groups = { UserDeleteGroup.class })
	@NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
	@Size(min = 0, max = 30)
	private String confirmPassword;

	@Null(groups = { UserCreateGroup.class })
	@NotNull(groups = { UserUpdateGroup.class, UserDeleteGroup.class })
	@Min(0)
	private Integer version;

	public Integer getId() {
		
		System.out.println("USEFORM:gettid!?" + id + "\n");
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		System.out.println("USEFORM:setid:" + id + "\n");
	}

	public String getName() {
		System.out.println("USEFORM:getName" +name + "\n");
		return name;
	}

	public void setName(String name) {
		System.out.println("USEFORM:setName" + name + "\n");
		this.name = name;
	}

	public Integer getEmail() {
		System.out.println("USEFORM:getEmail\n");
		return email;
	}

	public void setEmail(Integer email) {
		System.out.println("USEFORM:setmail\n");
		this.email = email;
	}

	public Integer getBirth() {
		System.out.println("USEFORM:getbirth!?\n");
		return birth;
	}

	public void setBirth(Integer birth) {
		System.out.println("USEFORM:setbirth!?\n");
		this.birth = birth;
	}

	public String getPassword() {
		System.out.println("USEFORM:getpass!?\n");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("USEFORM:setpassword!?\n");
		this.password = password;
	}

	public String getConfirmPassword() {
		System.out.println("USEFORM:getconfirmpassword!?\n");
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		System.out.println("USEFORM:setconfirmpassword\n");
		this.confirmPassword = confirmPassword;
	}

	public Integer getVersion() {
		System.out.println("USEFORM:getversion!?\n");
		return version;
	}

	public void setVersion(Integer version) {
		System.out.println("USEFORM:setversion\n");
		this.version = version;
	}
}
