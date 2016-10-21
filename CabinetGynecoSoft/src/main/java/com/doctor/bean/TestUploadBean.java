package com.doctor.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.JFileChooser;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "testUploadBean")
@SessionScoped
public class TestUploadBean {
	private String destination;
	private UploadedFile uploadedFile;
	private Integer idp;
	
	
	
	public Integer getIdp() {
		return idp;
	}

	public void setIdp(Integer idp) {
		this.idp = idp;
	}

	public UploadedFile getUploadedFile() {
		if (uploadedFile != null) {
			System.out.println("source get   " + uploadedFile.getFileName());
		} else
			System.out.println("c'est null ");
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		System.out.println("setup ");
		this.uploadedFile = uploadedFile;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Succesful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.addMessage(null, new FacesMessage(event.getFile().getFileName()));
		// enregistrer le ficher dan c:\temp
	}

	public void enregistrerSous() {
		JFileChooser filechoose = new JFileChooser();
		filechoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		String approve = new String("Enregistrer");
		int resultatEnregistrer = filechoose.showDialog(filechoose, approve);
		if (resultatEnregistrer == JFileChooser.APPROVE_OPTION) {
			destination = filechoose.getSelectedFile().getAbsolutePath();
		}
	}

	public void upload() {
		destination = "C:\\temp";
		if (uploadedFile != null) {
			System.out.println(uploadedFile);
			if (destination != null && destination.length() > 0) {
				File targetFolder = new File(destination);
				InputStream inputStream = null;
				OutputStream outputStream = null;
				try {
					inputStream = uploadedFile.getInputstream();
					outputStream = new FileOutputStream(new File(targetFolder,
							uploadedFile.getFileName()));
					int read = 0;
					final byte[] bytes = new byte[1024];
					while ((read = inputStream.read(bytes)) != -1) {
						outputStream.write(bytes, 0, read);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (outputStream != null) {
						try {
							outputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (inputStream != null) {
						try {
							inputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else
				System.out.println("destination vide");
		}
		else
			System.out.println("uploadedFile est null");
	}

}
