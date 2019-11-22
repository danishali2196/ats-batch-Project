package com.st.ats.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.st.ats.entity.TagDetailsEntity;

@Repository
public interface TagDetailsRepository extends JpaRepository<TagDetailsEntity, Serializable> {

	@Query("FROM TagDetailsEntity tde WHERE tde.tagId=tagId")
	public TagDetailsEntity findTagDetailById(Integer tagId);

}
