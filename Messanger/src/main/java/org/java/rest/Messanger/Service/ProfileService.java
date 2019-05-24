package org.java.rest.Messanger.Service;

import java.util.List;

import org.java.rest.Messanger.DAO.MessageDAO;
import org.java.rest.Messanger.DAO.ProfileDAO;
import org.java.rest.Messanger.pojo.Messages;
import org.java.rest.Messanger.pojo.Profile;

import net.bytebuddy.asm.Advice.Return;

public class ProfileService {
	ProfileDAO profileDao = new ProfileDAO();
	public void saveProfileService(Profile profile) {
		profileDao.saveProfile(profile);
	}
	public List<Profile> getProfileService() {
		return profileDao.getAllProfile();
	}
	public  Profile getProfileFromName(String profileName) {
		return profileDao.getProfileByName(profileName);
	}
	public Profile updateProfileService(Profile profile) {
		return profileDao.updateProfile(profile);
	}
	public Profile deleteProfileService(int id) {
		return profileDao.deleteProfile(id);
	}
		 
}
