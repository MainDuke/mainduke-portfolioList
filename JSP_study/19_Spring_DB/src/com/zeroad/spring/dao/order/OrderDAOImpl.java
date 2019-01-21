package com.zeroad.spring.dao.order;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.zeroad.spring.model.order.OrderInfo;
import com.zeroad.spring.model.order.OrderItem;

public class OrderDAOImpl implements OrderDAO{

	private SimpleJdbcTemplate jdbcTemplate=null; //����
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new SimpleJdbcTemplate(dataSource);
	}//end
	
	
	
	//1.�ֹ���ȣ ����
	static final public String getOrderSeqSQL(){
		return "select max(ordNo)+1 from orderinfo";
	}
	
	@Override
	public long getOrderSeq() {
		
		
		String sql=getOrderSeqSQL();		
		return jdbcTemplate.queryForLong(sql);
	}

	
	//2. orderinfo ���̺� insert �۾�
	private static String insertOrderSQL(){
		return "insert orderinfo values(:ordNo, :ordName, :rcvName, :delvAddr, :delvTel, now())";
	}

			
			
	@Override
	public long insertOrder(OrderInfo order) {
		String sql=insertOrderSQL();
		SqlParameterSource sqlParameterSource=new BeanPropertySqlParameterSource(order);
		this.jdbcTemplate.update(sql, sqlParameterSource);
		
		return order.getOrdNo();
	}

	
	//3. ��� �ֹ� ���� ��ȸ, select * from orderinfo
	static final String selectAll(){
		return "select ord.* from orderinfo ord";
	}
	
	@Override
	public List<OrderInfo> selectOrderAll() {
		
		String sql=selectAll();
		RowMapper<OrderInfo> mapper= new BeanPropertyRowMapper<OrderInfo>(OrderInfo.class);
		
		
		
		return this.jdbcTemplate.query(sql, mapper);
	}

	//4. �ֹ� ��ȸ ���� select * from orderinfo where ordNo=2;
	
	static final String selectOrder(){
		return "select ord.* from orderinfo ord where ordNo=?";
	}
	
	@Override
	public OrderInfo selectOrderInfo(long ordNo) {
		
		String sql=selectOrder();
		RowMapper<OrderInfo> mapper=new BeanPropertyRowMapper<OrderInfo>();
		
		return this.jdbcTemplate.queryForObject(sql, mapper, ordNo);
	}//end

	
	//5.�ֹ� �׸� ���� insert
	static final String insertOrderItemSQL(){
		return "insert orderitem values(0, :ordNo, :prdName, :cnt, :price)";
	}
	
	@Override
	public long insertOrderItem(OrderItem orderItem) {
		String sql=insertOrderItemSQL();
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(orderItem);
		return this.jdbcTemplate.update(sql, parameterSource);
	}
	
	//6. �ֹ� �׸� ��ȸ
	static final String selectIrderItemByOrderSQL(){
		return "select item.* from orderitem where ordNo=?";
	}
	
	@Override
	public List<OrderItem> selectOrderItem(long ordNo) {
		
		String sql=selectIrderItemByOrderSQL();
		RowMapper<OrderItem> mapper=new BeanPropertyRowMapper<OrderItem>();
				
		return this.jdbcTemplate.query(sql, mapper, ordNo);
	}

}
