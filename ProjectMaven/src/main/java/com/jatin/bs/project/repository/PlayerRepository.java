package com.jatin.bs.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jatin.bs.project.BO.PlayerBO;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerBO, Long> {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PlayerBO findById(Long id) {
		return jdbcTemplate.queryForObject("select * from player where playerid=?", new Object[] { id },
				new BeanPropertyRowMapper<PlayerBO>(PlayerBO.class));
	}*/

}