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
import com.exam.exception.ExcelSheetImport;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.QuestionsRepository;

@Service
public class QuestionsImpl {
	@Autowired
	QuestionsRepository questionsRepository;

	public List<QuestionEntity> getQuestions() {
		return questionsRepository.findAll();
	}

	public void saveQuestions(MultipartFile excelData) throws IOException, ExcelSheetImport {
		List<QuestionEntity> questionEntity = new ArrayList<QuestionEntity>();
		
		if(excelData.getOriginalFilename().length()==0)
		{
			throw new ExcelSheetImport("Please select an excel file.");
		}
		else if(!excelData.getOriginalFilename().endsWith(".xlsx"))
		{
			throw new ExcelSheetImport("File selected should be a Excel file.");
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook(excelData.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
			QuestionEntity questionEnty = new QuestionEntity();

			XSSFRow row = worksheet.getRow(i);
			
			int j=0;
			if (i == 0 &&!(row.getCell(j++).getStringCellValue().equalsIgnoreCase("question")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("choice1")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("choice2")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("choice3")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("choice4")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("correctAnswer")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("testSeries")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("questionMarks")
					&& row.getCell(j++).getStringCellValue().equalsIgnoreCase("hint"))) 
			{
				throw new ExcelSheetImport("Invalid file format.");
			}
			else if(i>0)
			{
			questionEnty.setQuestion(row.getCell(j++).getStringCellValue());
			questionEnty.setChoice1(row.getCell(j++).getStringCellValue());
			questionEnty.setChoice2(row.getCell(j++).getStringCellValue());
			questionEnty.setChoice3(row.getCell(j++).getStringCellValue());
			questionEnty.setChoice4(row.getCell(j++).getStringCellValue());
			questionEnty.setCorrectAnswer(row.getCell(j++).getStringCellValue());
			questionEnty.setTestSeries(row.getCell(j++).getStringCellValue());
			questionEnty.setQuestionMarks((int) row.getCell(j++).getNumericCellValue());
			questionEnty.setHint(row.getCell(j++).getStringCellValue());
			questionEntity.add(questionEnty);
			}
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
