package com.hrsoft.driver.entity;

import com.hrsoft.enums.WebRemoteModeType;
import com.hrsoft.enums.BrowserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter

public class WebDriverData {

	private BrowserType browserType;
	private WebRemoteModeType webRemoteModeType;

}