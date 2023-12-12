package obj;

import java.sql.Blob;
import java.util.Date;

public class ImageObject {
	
	Integer imgId;
	Blob imgContent;
	String imgName;
	String imgDescription;
	String imgType;
	Date dateCreated;
	
	public ImageObject() {
	}
	
	public ImageObject(Integer imgId, String imgName, String imgDescription, String imgType, Date dateCreated) {
		
		super();
		this.imgId = imgId;
		this.imgName = imgName;
		this.imgDescription = imgDescription;
		this.imgType = imgType;
		this.dateCreated = dateCreated;
		
	}
	
	@Override
	public String toString() {
		return "Product [imgId=" + imgId + ", imgName=" + imgName + ", imgDescription=" + imgDescription + ", imgType=" + imgType + ", dateCreated=" + dateCreated + "]";
	}

	public Integer getImgId() {
		return imgId;
	}
	
	public Blob getImgContent() {
		return imgContent;
	}

	public String getImgName() {
		return imgName;
	}

	public String getImgDescription() {
		return imgDescription;
	}

	public String getImgType() {
		return imgType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	
	public void setImgContent(Blob imgContent) {
		this.imgContent = imgContent;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public void setImgDescription(String imgDescription) {
		this.imgDescription = imgDescription;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
