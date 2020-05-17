package com.basicwebapp.data.aws;

import com.amazonaws.regions.Regions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDataS3 {
	
	 private Regions clientRegion;
	 private String bucketName ;
	 private String keyName;
	 private String filePath ;

/*	 ServiceDataS3(Regions clientRegion,String bucketName,String keyName,String filePath){
		 
		 this.clientRegion =clientRegion;
		 this.bucketName =bucketName;
		 this.keyName= keyName;
		 this.filePath=filePath;
		} 
	 */

}
