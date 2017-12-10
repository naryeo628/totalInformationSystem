package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from offers where name=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { name }, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setTerm(rs.getInt("term"));
				offer.setCord(rs.getString("cord"));
				offer.setName(rs.getString("name"));
				offer.setType(rs.getString("type"));
				offer.setGrade(rs.getDouble("grade"));

				return offer;
			}
		});
	}

	// query and return a multiple object
	public List<Offer> getOffers() {
		String sqlStatement = "select * from offers";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setTerm(rs.getInt("term"));
				offer.setCord(rs.getString("cord"));
				offer.setName(rs.getString("name"));
				offer.setType(rs.getString("type"));
				offer.setGrade(rs.getDouble("grade"));
				
				/*
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));*/

				return offer;
			}
		});
	}

	public boolean insert(Offer offer) {

		int year = offer.getYear();
		int term = offer.getTerm();
		String cord = offer.getCord();
		String name = offer.getName();
		String type = offer.getType();
		double grade = offer.getGrade();
		/*String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();*/

		String sqlstatement = "insert into offers (year, term, cord, name, type, grade) values (?, ?, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlstatement, new Object[] { year, term, cord, name, type, grade }) == 1);
	}

	public boolean update(Offer offer) {

		int id = offer.getId();
		
		int year = offer.getYear();
		int term = offer.getTerm();
		String cord = offer.getCord();
		String name = offer.getName();
		String type = offer.getType();
		double grade = offer.getGrade();
		
		/*String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();*/

		String sqlstatement = "update offers set name=?, email=?, text=? where id=?";

		return (jdbcTemplate.update(sqlstatement, new Object[] { year, term, cord, name, type, grade, id }) == 1);
	}

	public boolean delete(int id) {
		String sqlstatement = "delete from offers where id=?";

		return (jdbcTemplate.update(sqlstatement, new Object[] { id }) == 1);
	}
}
