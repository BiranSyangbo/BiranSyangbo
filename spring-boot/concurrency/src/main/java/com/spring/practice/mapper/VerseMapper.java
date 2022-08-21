package com.spring.practice.mapper;

import com.spring.practice.domain.Verse;
import com.spring.practice.dto.VerseDto;
import org.mapstruct.Mapper;


public interface VerseMapper {

    public Verse verseMapper(VerseDto verseDto);

}
