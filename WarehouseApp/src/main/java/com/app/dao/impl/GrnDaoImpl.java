package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IGrnDao;
import com.app.model.Grn;
import com.app.model.GrnDtl;




@Repository
public class GrnDaoImpl implements IGrnDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveGrn(Grn g) {

		return (Integer)ht.save(g);
	}

	@Override
	public void updateGrn(Grn g) {

		ht.update(g);

	}

	@Override
	public void deleteGrn(Integer id) {
		Grn g=ht.get(Grn.class, id);
		g.setId(id);
		ht.delete(g);

	}

	@Override
	public Grn getOneGrn(Integer id) {
		Grn g=ht.get(Grn.class,id);
		return g;
	}

	@Override
	public List<Grn> getAllGrn() {
		List<Grn> g=ht.loadAll(Grn.class);
		return g;
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getGrnTypeAndCount() {
		String hql="select grnOCode,count(grnOCode) from com.app.model.Grn group by grnOCode";
		return (List<Object[]>)ht.find(hql);
	}

	@Override
	public Integer saveGrnDtl(GrnDtl dtl) {

		return (Integer) ht.save(dtl);
	}

	@Override
	public List<GrnDtl> getGrnDtlByGrnId(Integer id) {
		//select *from grndtl where grnIdFk=?
		DetachedCriteria dc=DetachedCriteria.forClass(GrnDtl.class)
				.add(Restrictions.eq("parent.id", id));

		return (List<GrnDtl>) ht.findByCriteria(dc);
	}

}






