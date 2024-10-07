package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	CommentRepository repository;
	
	@Test
	void 댓글등록() {
		
		Member member = Member.builder()
							  .id("zxc")
							  .build();
		
		Board board = Board.builder()
						   .no(8)						   
						   .build();
		
		Comment comment = new Comment(0, board, "댓글1", member);
		
		Member member2 = Member.builder()
				  				.id("admin")
				  				.build();

		Board board2 = Board.builder()
							   .no(9)						   
							   .build();
		
		Comment comment2 = new Comment(0, board2, "댓글2", member2);
							
		
		repository.save(comment);
		repository.save(comment2);
		
	}
	
	@Test
	void 댓글단건조회() {
		
		Optional<Comment> optional = repository.findById(2);
		if(optional.isPresent()){
			Comment comment = optional.get();
			System.out.println(comment);
		}
		
	}
	
	@Test
	void 댓글목록조회() {
		List<Comment> list = repository.findAll();
		for(Comment comment : list) {
			System.out.println(comment);
		}
	}
	
	@Test
	void 댓글수정() {
		Optional<Comment> optional = repository.findById(2);
		Comment comment = optional.get();
		comment.setContent("내용수정1ㅋㅌㅊ");
		repository.save(comment);
	}
	
	@Test
	void 댓글삭제() {
		repository.deleteById(3);
	}
	
	@Test
	public void 게시물별_댓글조회() {
	
		// 1번 게시물에 달린 댓글 목록 조회
		Board board = Board.builder()
						   .no(8)
						   .build();
		
		List<Comment> list = repository.findByBoard(board);
		
		for(Comment comment : list) {
			System.out.println(comment);
		}
		
	}
	
	@Test
	public void 게시물별_댓글삭제() {
		
		Board board = Board.builder()
							.no(8)
							.build();
		
		repository.deleteByBoard(board);
	}
	
}
