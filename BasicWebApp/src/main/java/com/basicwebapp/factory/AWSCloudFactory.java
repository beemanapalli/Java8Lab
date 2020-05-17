package com.basicwebapp.factory;

 

public interface AWSCloudFactory<T,I> {

	T createClientConnectionForS3(I serviceDataS3);
}
