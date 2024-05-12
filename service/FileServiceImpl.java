package com.jh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.dao.FileDao;
import com.jh.dto.FileDto;
@Service
public class FileServiceImpl implements FileService{
	@Autowired
	FileDao dao;
	
	
	@Override
	public void insertFile(FileDto dto) {
		dao.insertFile(dto);
	}

}
