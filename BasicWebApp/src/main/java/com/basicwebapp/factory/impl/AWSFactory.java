package com.basicwebapp.factory.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.basicwebapp.data.aws.ServiceDataS3;
import com.basicwebapp.factory.AWSCloudFactory;

public class AWSFactory  implements AWSCloudFactory<AmazonS3,ServiceDataS3> {
	
  
	public AmazonS3 createClientConnectionForS3(ServiceDataS3 serviceDataS3){
		
		AmazonS3 s3Client =null;
		try {
               s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(serviceDataS3.getClientRegion())
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();
               return s3Client;
		} catch (AmazonServiceException e) {
           
            e.printStackTrace();
        } catch (SdkClientException e) {
             
            e.printStackTrace();
        }
		return null;
	}

}
