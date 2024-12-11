package com.keremk.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keremk.dto.DtoHome;
import com.keremk.dto.DtoRoom;
import com.keremk.entites.Home;
import com.keremk.entites.Room;
import com.keremk.repository.HomeRepository;
import com.keremk.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	HomeRepository homeRepository;

	@Override
	public DtoHome findHomeById(Long id) {
		DtoHome dtoHome = new DtoHome();
		Optional<Home> optionalHomeOptional=  homeRepository.findById(id);
		if(optionalHomeOptional.isEmpty()) {
			return null;
		}
		{
			Home dbhome = optionalHomeOptional.get();
			List<Room> dbRooms = optionalHomeOptional.get().getRoom();
			
			BeanUtils.copyProperties(dbhome, dtoHome);
			
			if(dbRooms !=null && !dbRooms.isEmpty()) {
				
				for (Room room : dbRooms) {
					DtoRoom dtoRoom = new DtoRoom();
					BeanUtils.copyProperties(room, dtoRoom);
					dtoHome.getRooms().add(dtoRoom);
				}
				
		
				
			}
			
			return dtoHome;
			
		    
			
			
		}
		
	
	}

	
}
