package main.com.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Date;

import main.com.business.User;
import main.com.dateformat.JsonDateDeserializer;
import main.com.dateformat.JsonDateSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter extends Converter{

	/**
	 * It initializes the users list if it's being used for the first time
	 * @param file
	 */
	public JsonConverter() {
		Converter.users = this.getUsers();
	}
	
	/**
	 * Sets the file to be unserialized
	 * It initializes the users list if it's being used for the first time
	 * @param file
	 */
	public JsonConverter(String file) {
		this.file=file;
		Converter.users = this.getUsers();
	}

	/**
	 * This method parses json files and saves the values into the static users list
	 */
	@Override
	public void unserialize() {
		try
		{
			File file = new File(this.getFile());
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new JsonDateDeserializer());
			
			Gson gson = gsonBuilder.create();
			User[] userArray = gson.fromJson(br, User[].class);
			//System.out.println(userArray.length);

			Converter.users.addAll(Arrays.asList(userArray));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * This method generates json file from users list
	 *  @return String file name
	 */
	@Override
	public String serialize() {
		
		String generatedFileName = null;
		try
		{
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new JsonDateSerializer());
			Gson gson = gsonBuilder.create();
			
			if(Converter.users.getUsers().size()>0)
			{
				generatedFileName = generateFileName()+".json";
				FileOutputStream os=new FileOutputStream(generatedFileName,true);
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
				bw.append(gson.toJson(Converter.users.getUsers()));
				bw.close();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		return generatedFileName;
	}
	

}
