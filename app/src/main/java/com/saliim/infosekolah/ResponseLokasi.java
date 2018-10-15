package com.saliim.infosekolah;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLokasi {

	@SerializedName("code")
	private int code;

	@SerializedName("data_lokasi")
	private List<DataLokasiItem> dataLokasi;

	@SerializedName("message")
	private String message;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setDataLokasi(List<DataLokasiItem> dataLokasi){
		this.dataLokasi = dataLokasi;
	}


	public List<DataLokasiItem> getDataLokasi(){
		return dataLokasi;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLokasi{" +
			"code = '" + code + '\'' + 
			",data_lokasi = '" + dataLokasi + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}