package org.coin.jusomanager.service;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
@IdClass(JusoId.class)
public class Juso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// 시군구 코드
	@Column(name = "sggCd", length = 5)
	String sggCd;
	
	// 출입구 일련번호
	@Column(name = "doorCd", length = 10)
	String doorCd;
	
	// 법정동코드 (시군구코드(5) + 읍면동코드(3) + 00)
	@Id
	@Column(name = "dongCd", length = 10)
	String dongCd;
	
	// 시도명
	@Column(name = "siNm", length = 40)
	String siNm;
	
	// 시군구명
	@Column(name = "sggNm", length = 40)
	String sggNm;
	
	// 읍면동명
	@Column(name = "emdNm", length = 40)
	String emdNm;
	
	// 도로명코드 (시군구코드(5)+도로명번호(7))
	@Id
	@Column(name = "rnMgSn", length = 12)
	String rnMgSn;
	
	// 도로명
	@Column(name = "rn", length = 80)
	String rn;
	
	// 지하여부
	@Id
	@Column(name = "udrtYn", length = 1)
	String udrtYn;
	
	// 건물본번
	@Id
	@Column(name = "buldMnnm", length = 5)
	String buldMnnm;
	
	// 건물부번
	@Id
	@Column(name = "buldSlno", length = 5)
	String buldSlno;
	
	// 건물명
	@Column(name = "bdNm", length = 40)
	String bdNm;
	
	// 우편번호
	@Column(name = "zipNo", length = 5)
	String zipNo;
	
	// 건물용도분류 (복수 건물용도가 존재시 콤마(,)로 구분)
	@Column(name = "buldTp", length = 100)
	String buldTp;
	
	// 건물군여부 (0:단독건물, 1:건물군)
	@Column(name = "bdKdcd", length = 1)
	String bdKdcd;
	
	// 관할행정동
	@Column(name = "admNm", length = 8)
	String admNm;
	
	// X좌표(GRS80)
	@Column(name = "entX", length = 15)
	String entX;
	
	// Y좌표(GRS80)
	@Column(name = "entY", length = 15)
	String entY;
	
	// 이동사유코드
	@Column(name = "reason", length = 2)
	String reason;
	
	// 경도
	@Column(name = "longitude", length = 15)
	String longitude;
	
	// 위도
	@Column(name = "latitude", length = 15)
	String latitude;

}
