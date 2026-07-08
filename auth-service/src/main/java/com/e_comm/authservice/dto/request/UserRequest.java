package com.e_comm.authservice.dto.request;

import com.e_comm.authservice.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
	@NotBlank(message = "Please enter FirstName")
	private String firstName;
	@NotBlank(message = "Please enter LastName")
	private String lastName;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Please enter a valid email")
    private String email;
	@Size(min = 8)
	@NotBlank(message = "Please enter Password")
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Pattern(regexp = "^[6-9]\\d{9}$",message = "Please enter valid PhoneNumber")
	private String phoneNumber;
	
	@NotNull(message = "Please enter Role")
	private Role role;
	@NotBlank(message = "Please enter Active status")
	private Boolean isActive;

}
