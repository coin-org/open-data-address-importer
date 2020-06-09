package org.coin.jusomanager.service;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JusoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 법정동코드 (시군구코드(5) + 읍면동코드(3) + 00)
	@Column(name = "dongCd", length = 10)
	String dongCd;
	
	// 도로명코드 (시군구코드(5)+도로명번호(7))
	@Column(name = "rnMgSn", length = 12)
	String rnMgSn;
	
	// 지하여부
	@Column(name = "udrtYn", length = 1)
	String udrtYn;
	
	// 건물본번
	@Column(name = "buldMnnm", length = 5)
	String buldMnnm;
	
	// 건물부번
	@Column(name = "buldSlno", length = 5)
	String buldSlno;

}
