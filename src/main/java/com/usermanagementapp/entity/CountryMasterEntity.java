package com.usermanagementapp.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class CountryMasterEntity {

	@Id
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
}
