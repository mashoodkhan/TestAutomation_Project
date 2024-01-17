package com.hrsoft.driver.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import com.hrsoft.driver.IWebDriver;
import com.hrsoft.driver.implement.LocalWebDriveImp;
import com.hrsoft.driver.implement.RemoteWebDriveImp;
import com.hrsoft.enums.RunModeType;

public class DriverFactory {

	private DriverFactory() {
	}

	private static final Map<RunModeType, Supplier<IWebDriver>> WEB = new EnumMap<>(RunModeType.class);

	static {
		WEB.put(RunModeType.LOCAL, LocalWebDriveImp::new);
		WEB.put(RunModeType.REMOTE, RemoteWebDriveImp::new);
	}

	public static IWebDriver getDriverForWeb(RunModeType runModeType) {
		return WEB.get(runModeType).get();
	}

	// ** Place holder for mobile driver - To Be Implemented */
	public static IWebDriver getDriverForMobile() {
		return null;
	}

}
