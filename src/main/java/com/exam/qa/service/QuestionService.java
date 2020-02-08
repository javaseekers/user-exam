package com.exam.qa.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exam.qa.entities.TestPaperEntity;
import com.exam.qa.repo.QuestionsRepository;

@Service
public class QuestionService
{
	@Autowired
	private QuestionsRepository questionsRepository;

	public List<TestPaperEntity> getQuestion()
	{
		return questionsRepository.findAll();
	}

	public List<TestPaperEntity> uploadQuestions(MultipartFile file)
		throws IOException
	{
		List<TestPaperEntity> testPaperEntityList = new ArrayList<TestPaperEntity>();

		XSSFWorkbook questionsWorkbook = new XSSFWorkbook(
			file.getInputStream());

		XSSFSheet worksheet = questionsWorkbook.getSheetAt(0);

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++)
		{
			XSSFRow row = worksheet.getRow(i);

			TestPaperEntity testPaperEntity = new TestPaperEntity();

			testPaperEntity.setTestSeries(row.getCell(0).getStringCellValue());
			testPaperEntity.setQuestion(row.getCell(1).getStringCellValue());
			testPaperEntity.setChoice1(row.getCell(2).getStringCellValue());
			testPaperEntity.setChoice2(row.getCell(3).getStringCellValue());
			testPaperEntity.setChoice3(row.getCell(4).getStringCellValue());
			testPaperEntity.setChoice4(row.getCell(5).getStringCellValue());
			testPaperEntity.setHint(row.getCell(6).getStringCellValue());
			testPaperEntity.setAnswer(row.getCell(7).getStringCellValue());

			testPaperEntity
				.setQuestionMarks((int) row.getCell(8).getNumericCellValue());

			testPaperEntityList.add(testPaperEntity);

		}
		return questionsRepository.saveAll(testPaperEntityList);
	}

	public List<TestPaperEntity> getQuestionsBySeries(String testSeries)
	{
		return questionsRepository.getByTestSeries(testSeries);
	}
}