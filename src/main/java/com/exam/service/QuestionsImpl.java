package com.exam.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exam.entities.QuestionEntity;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.QuestionsRepository;

@Service
public class QuestionsImpl {
	@Autowired
	QuestionsRepository questionsRepository;

	public List<QuestionEntity> getQuestions() {
		return questionsRepository.findAll();
	}

	public void saveQuestions(MultipartFile excelData) throws IOException {
		List<QuestionEntity> questionEntity = new ArrayList<QuestionEntity>();
		XSSFWorkbook workbook = new XSSFWorkbook(excelData.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			QuestionEntity questionEnty = new QuestionEntity();

			XSSFRow row = worksheet.getRow(i);

			questionEnty.setQuestion(row.getCell(0).getStringCellValue());
			questionEnty.setChoice1(row.getCell(1).getStringCellValue());
			questionEnty.setChoice2(row.getCell(2).getStringCellValue());
			questionEnty.setChoice3(row.getCell(3).getStringCellValue());
			questionEnty.setChoice4(row.getCell(4).getStringCellValue());
			questionEnty.setCorrectAnswer(row.getCell(5).getStringCellValue());
			questionEnty.setTestSeries(row.getCell(6).getStringCellValue());
			questionEnty.setQuestionMarks((int) row.getCell(7).getNumericCellValue());
			questionEnty.setHint(row.getCell(8).getStringCellValue());
			questionEntity.add(questionEnty);
		}
		questionsRepository.saveAll(questionEntity);
	}

	public List<QuestionEntity> getQuestionsBySeries(String testSeries) throws ResourceNotFoundException {
		List<QuestionEntity> localLt = new ArrayList<QuestionEntity>();
		localLt = questionsRepository.getQuestionsByTestSeries(testSeries);
		if (localLt == null) 
		{
			throw new ResourceNotFoundException("Questions are not available for the given test series :" + testSeries);
		}
		return localLt;
	}

}
