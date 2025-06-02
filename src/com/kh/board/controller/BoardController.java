package com.kh.board.controller;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.view.BoardView;

/* 
 * View요청에 맞는 Service를 선택하여 메서드를 실행 한 후 결과값을 돌려주는 클래스.
 * */
public class BoardController {
	
	private BoardService bs = new BoardService();
	// service 변수 선언 및 초기화
	
	// view의 login요청을 담당할 메서드
	public void logIn(String memberId, String memberPwd) {
		Board b = new Board(memberId,memberPwd);
		
		int result = bs.checkId(b);
		
		if(result == 1) {
			new BoardView().displaySeuccess("로그인 성공");
		}else {
			new BoardView().displayFail("로그인 실패");
		}
	}
	
	
	// view의 selectBoardList요청을 담당할 메서드
	public void selectAll() {
		
	}
	// view의 selectBoardList요청을 담당할 메서드
	
	// view의 selectBoard요청을 담당할 메서드
	
	// view의 insertBoard요청을 담당할 메서드
	
	// view의 updateBoard요청을 담당할 메서드
	
	// view의 deleteBoard요청을 담당할 메서드
	
	
			
}
