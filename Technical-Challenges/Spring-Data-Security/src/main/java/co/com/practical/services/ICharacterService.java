package co.com.practical.services;

import java.util.List;

public interface ICharacterService {
	
	public List<Character> getConsult ();
	
	public Character getConsultId (Long id);
	
	public Character save_Character (Character character);
	
	public void delete_Character (Character character);

}
