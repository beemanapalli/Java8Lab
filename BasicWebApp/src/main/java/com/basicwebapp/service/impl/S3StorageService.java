package com.basicwebapp.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import com.basicwebapp.data.aws.ServiceDataS3;
import com.basicwebapp.factory.AWSCloudFactory;
import com.basicwebapp.factory.impl.FactoryConsts;
import com.basicwebapp.factory.impl.FactoryProvider;
import com.basicwebapp.service.StorageServce;

import lombok.NonNull;

import com.basicwebapp.util.FileUtil;

@Service
public class S3StorageService implements StorageServce {

	
	@NonNull
	AWSCloudFactory<AmazonS3,ServiceDataS3> factory;
	
	@NonNull
	AmazonS3 s3Client;
	
	@NonNull
	TransferManager transactionMGR;
	
	@NonNull
	File convertedFile;
	
	public boolean store(MultipartFile file) {
	 

try {
	    convertedFile =FileUtil.convertToFile(file);
        //Upload upload = transactionMGR.upload(FactoryConsts.BUCKET_NAME, FactoryConsts.KEY_NAME, new File(FactoryConsts.FILE_PATH));
	    Upload upload = transactionMGR.upload(FactoryConsts.BUCKET_NAME, file.getOriginalFilename(), convertedFile);
		
        System.out.println("Object upload started");

        // Optionally, wait for the upload to finish before continuing.
        //upload.waitForCompletion();
        System.out.println("Object upload complete");
}catch(Exception e) {
	e.printStackTrace();
}
		return false;
	}
	
	
	@Override
	public void loadConfig() {
		ServiceDataS3 serviceDataS3 =new ServiceDataS3();
		serviceDataS3.setClientRegion(FactoryConsts.CLIENT_REGION);
	
		factory =FactoryProvider.getFactory(FactoryConsts.AWS_FACTORY);
		s3Client =factory.createClientConnectionForS3(serviceDataS3);
		transactionMGR = TransferManagerBuilder.standard()
                 .withS3Client(s3Client)
                 .build();
	}

}
