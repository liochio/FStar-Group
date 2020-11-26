package com.dichvudulich;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.dichvudulich.FileEntity.FilesStorageService;
import com.dichvudulich.FileEntity.StorageProperties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(StorageProperties.class)
public class Application implements CommandLineRunner {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

}
