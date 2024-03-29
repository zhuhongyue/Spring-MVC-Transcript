package demo.mvc.web;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import demo.mvc.model.User;
import demo.mvc.model.UserForm;
import demo.mvc.model.UserForm.UserCreateGroup;
import demo.mvc.model.UserForm.UserDeleteGroup;
import demo.mvc.model.UserForm.UserUpdateGroup;
import demo.mvc.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Inject
	protected UserService userService;

	@Inject
	protected Mapper beanMapper;

	@ModelAttribute
	public UserForm setUpUserForm() {
		return new UserForm();
	}

	// create flow

	@RequestMapping(value = "create", params = "form", method = RequestMethod.GET)
	public String createForm(UserForm form) {
		System.out.println("USECONTROLLER:CreateFORM\n");
		form.setEmail(11122000);
		form.setId(0);
		form.setName("Tom Bruise");
		return "user/createForm";
	}

	@RequestMapping(value = "create", params = "confirm", method = RequestMethod.POST)
	public String createConfirm(@Validated({ Default.class,
			UserCreateGroup.class }) UserForm form, BindingResult result) {
		System.out.println("createConfirm!?\n");
		
		if (result.hasErrors()) {
			return "user/createForm";
		}
		return "user/createConfirm";
	}

	@RequestMapping(value = "create", params = "redo", method = RequestMethod.POST)
	public String createRedo(UserForm form) {
		// reset password
		System.out.println("USECONTROLLER:CreateREDO\n");
		form.setPassword("");
		form.setConfirmPassword("");
		return "user/createForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(
			@Validated({ Default.class, UserCreateGroup.class }) UserForm form,
			BindingResult result) {
		System.out.println("USECONTROLLER:Creat\n");
		if (result.hasErrors()) {
			return "user/createForm";
		}
		System.out.println("USECONTROLLER:Creat -> save\n");
		User user;
		System.out.println("USECONTROLLER:Creat -> save -> user\n");
		user = beanMapper.map(form, User.class);
		System.out.println("USECONTROLLER:Creat -> save -> build\n");
		userService.save(user, form.getPassword());
		System.out.println("USECONTROLLER:Creat -> save -> complate\n");
		return "redirect:/user/create?complete";
	}

	@RequestMapping(value = "create", params = "complete", method = RequestMethod.GET)
	public String createComplete() {
		
		return "user/createComplete";
	}

	// update flow

	@RequestMapping(value = "update", params = "form", method = RequestMethod.GET)
	public String updateForm(@RequestParam("id") Integer id, UserForm form,
			Model model) {

		User user = userService.findOne(id);
		beanMapper.map(user, form, "userExcludePassword");

		model.addAttribute(user);
		
		return "user/updateForm";
	}

	@RequestMapping(value = "update", params = "confirm", method = RequestMethod.POST)
	public String updateConfirm(@Validated({ Default.class,
			UserUpdateGroup.class }) UserForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "user/updateForm";
		}
		return "user/updateConfirm";
	}

	@RequestMapping(value = "update", params = "redo", method = RequestMethod.POST)
	public String updateRedo(@RequestParam("id") Integer id, UserForm form,
			Model model) {

		// reset password
		form.setPassword("");
		form.setConfirmPassword("");

		return "user/updateForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(
			@Validated({ Default.class, UserUpdateGroup.class }) UserForm form,
			BindingResult result) {
		if (result.hasErrors()) {
			return "user/updateForm";
		}
		System.out.println("USECONTROLLER:update\n");
		User user ;
		System.out.println("USECONTROLLER:update -> findone -> map \n");
		user = userService.findOne(form.getId());
		System.out.println("USECONTROLLER:update -> findone ->user \n");
		beanMapper.map(form, user);
		System.out.println("USECONTROLLER:update -> findone -> map \n");
		userService.save(user, form.getPassword());
		System.out.println("USECONTROLLER:update -> findone -> map -> save\n");
		return "redirect:/user/update?complete";
	}

	@RequestMapping(value = "update", params = "complete", method = RequestMethod.GET)
	public String updateComplete() {
		return "user/updateComplete";
	}

	// delete flow

	@RequestMapping(value = "delete", params = "form", method = RequestMethod.GET)
	public String deleteForm(@RequestParam("id") Integer id, UserForm form,
			Model model) {
		System.out.println("USECONTROLLER:delete\n");
		User user = userService.findOne(id);
		beanMapper.map(user, form);
		
		model.addAttribute(user);
		System.out.println("USECONTROLLER:delete -> goto deleteForm.jsp\n");
		return "user/deleteForm";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(
			@Validated({ Default.class, UserDeleteGroup.class }) UserForm form,
			BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			attr.addFlashAttribute("errorMessage", "Illegal Access!");
			return "redirect:/user/list";
		}

		User user = userService.findOne(form.getId());
		beanMapper.map(form, user);

		userService.delete(user);
		System.out.println("USECONTROLLER:delete -> goto deleteComplete.jsp\n");
		return "redirect:/user/delete?complete";
	}

	@RequestMapping(value = "delete", params = "complete")
	public String deleteComplete() {
		System.out.println("USECONTROLLER:deleteComplete -> goto deleteComplete.jsp\n");
		return "user/deleteComplete";
	}

	@RequestMapping(value = { "create", "update", "delete" }, params = "redirectToList")
	public String redirectToList() {
		System.out.println("USECONTROLLER:redirectToList -> goto list.jsp\n");
		return "redirect:/user/list";
	}
}
