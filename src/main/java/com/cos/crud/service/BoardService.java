package com.cos.crud.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;

@Service
public class BoardService {
	//DB관련 로직만 서비스에 필요함
	
	@Autowired
	private BoardRepository mRepo;
	
	@Transactional
	public void increaseCountAndTimeUpdate(int id) {
		try {
			mRepo.increaseCount(id);
			mRepo.timeUpdate(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Board> boardList() {
		List<Board> boards = mRepo.findAll();
		return boards;
	}
	
	public Board boardDetail(int id) {
		Optional<Board> board = mRepo.findById(id);
		return board.get();
	}
	
	public int boardWrite(Board board,HttpSession session) {
		try {
			User user = (User)session.getAttribute("user");
			board.setUser(user);
			mRepo.save(board);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int boardDelete(int id) {
		try {
			mRepo.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Board boardUpdateForm(int id) {
		Optional<Board> board = mRepo.findById(id);
		return board.get();
	}
	
	public int boardUpdate(Board board) {
		try {
			Optional<Board> b = mRepo.findById(board.getId());
			Board bb = b.get();
			bb.setTitle(board.getTitle());
			bb.setContent(board.getContent());
			mRepo.save(bb);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	
	}
}
