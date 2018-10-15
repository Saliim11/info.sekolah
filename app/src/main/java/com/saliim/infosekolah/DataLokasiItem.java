package com.saliim.infosekolah;

import com.google.gson.annotations.SerializedName;

public class DataLokasiItem{

	@SerializedName("namelocation")
	private String namelocation;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("id")
	private String id;

	@SerializedName("longitude")
	private String longitude;

	public void setNamelocation(String namelocation){
		this.namelocation = namelocation;
	}

	public String getNamelocation(){
		return namelocation;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String  getLatitude(){
		return latitude;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"DataLokasiItem{" + 
			"namelocation = '" + namelocation + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",id = '" + id + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}