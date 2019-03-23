package com.thoersch.seeds.representations.branches;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thoersch.seeds.persistence.converters.LocalDateConverter;
import com.thoersch.seeds.persistence.converters.LocalDateTimeConverter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@javax.persistence.Entity
@Table(name = "branches")
public class Branches {

	@Id
	@Length(max = 255)
    private String ifsc;
    
    @Length(max = 255)
    @NotNull
    private String branch;
    
    public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
