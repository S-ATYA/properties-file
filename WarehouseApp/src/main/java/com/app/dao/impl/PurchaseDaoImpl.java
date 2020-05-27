package com.app.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;
import com.app.model.PurchaseDetails;

@Repository
public class PurchaseDaoImpl implements IPurchaseDao {

	@Autowired
	private HibernateTemplate ht;
	
	
	public Integer savePurchase(Purchase p) {
		return (Integer) ht.save(p);
	}

	
	public void updatePurchase(Purchase p) {
		ht.update(p);
	}


	public void deletePurchase(Integer id) {
		Purchase p=new Purchase();
		p.setId(id);
		ht.delete(p);
	}


	public Purchase getOnePurchase(Integer id) {
			Purchase p=ht.get(Purchase.class, id);
		return p;
	}

	public List<Purchase> getAllPurchases() {
		List<Purchase> l=ht.loadAll(Purchase.class);
		return l;
	}

	@Override
	public Integer savePurchaseDetails(PurchaseDetails purchaseDetails) {
		return (Integer) ht.save(purchaseDetails);
	}


	@Override
	public List<Object[]> getPurchaseIdAndCode() {
		DetachedCriteria dc=DetachedCriteria.forClass(Purchase.class)
				.setProjection(
						Projections.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("orderCode"))
						)
				.add(Restrictions.eq("status", "INVOICED"));
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(dc);
		
		return list;
	}


	@Override
	public void updateStatusById(Integer id, String status) {
		ht.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {
				String hql=" update com.app.model.Purchase p "
						+ " set p.status=:a "
						+ " where p.id=:b";
				
				return session.createQuery(hql)
						.setParameter("a", status)
						.setParameter("b", id)
						.executeUpdate();
			}
		});
		
	}
	

		
	}
	

