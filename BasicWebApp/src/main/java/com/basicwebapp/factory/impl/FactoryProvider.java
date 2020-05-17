package com.basicwebapp.factory.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.basicwebapp.data.aws.ServiceDataS3;
import com.basicwebapp.factory.AWSCloudFactory;

import lombok.NonNull;


public class FactoryProvider {

	public static AWSCloudFactory<AmazonS3,ServiceDataS3> getFactory(@NonNull String factoryName) {
		if(FactoryConsts.AWS_FACTORY.equalsIgnoreCase("AWS_FACTORY"))
			return new AWSFactory();
		
		return null;
	}
	
}
