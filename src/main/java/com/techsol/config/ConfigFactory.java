package com.techsol.config;

import org.aeonbits.owner.ConfigCache;

import com.hrsoft.utils.owner.IFrameworkConfig;

public final class ConfigFactory {

	 ConfigFactory() {
	}

	public static IFrameworkConfig getConfig() {
		return ConfigCache.getOrCreate(IFrameworkConfig.class);
	}

}