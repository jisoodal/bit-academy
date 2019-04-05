package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

// @Component - 스프링에게 해당 클래스가 스프링에서 관리해야 하는 대상임을 표시하는 어노테이션.
@Component
@Data
public class Restaurant {
	
	// 자동으로 setChef()를 컴파일 시 생성한다.
	@Setter(onMethod_ = @Autowired)
	private Chef chef;

}
