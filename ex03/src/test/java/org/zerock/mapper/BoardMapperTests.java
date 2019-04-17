package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board); // BoardVO의 @Data 덕분에 자동으로 getter, setter, toString, equals를 사용할 수 있고, 
						 // 이렇게 그냥 print만 하는 경우에는 변수명만 써주면 toString으로 출력해준다.
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		
		BoardVO board = mapper.read(23L); // bno가 23인 행
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
	
		log.info("DELETE COUNT: "+mapper.delete(33L));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		
		board.setBno(30L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: "+ count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri= new Criteria();
		// 10개씩 3페이지
		
		cri.setPageNum(3);
		cri.setAmount(13);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
//	@Test
//	public void testListPaging() throws Exception {
//		
//		log.info(mockMvc.perform(
//				MockMvcRequestBuilders.get("/board/list")
//				.param("pageNum", "2")
//				.param("amount", "50"))
//				.andReturn().getModelAndView().getModelMap());
//	}
	
	@Test
	public void testSearch() {
		
		Criteria cri= new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
}
