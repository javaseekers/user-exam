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
import com.exam.qa.exceptions.ExcelDataImport;
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

	public void uploadQuestions(MultipartFile file) throws IOException
	{
		List<TestPaperEntity> testPaperEntityList = new ArrayList<TestPaperEntity>();

		if (file.getOriginalFilename().length() == 0)
		{
			throw new ExcelDataImport(
				"error.please.seelct.file.to.upload");
		}
		else if (!file.getOriginalFilename().endsWith(".xlsx"))
		{
			throw new ExcelDataImport(
				"error.please.seelct.excel.to.upload");
		}

		XSSFWorkbook questionsWorkbook = new XSSFWorkbook(
			file.getInputStream());

		XSSFSheet worksheet = questionsWorkbook.getSheetAt(0);

		for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++)
		{
			XSSFRow row = worksheet.getRow(i);

			int j = 0;

			if (i == 0 && !(row.getCell(j++).getStringCellValue()
				.equals("testSeries")
					&& row.getCell(j++).getStringCellValue().equals("question")
					&& row.getCell(j++).getStringCellValue().equals("choice1")
					&& row.getCell(j++).getStringCellValue().equals("choice2")
					&& row.getCell(j++).getStringCellValue().equals("choice3")
					&& row.getCell(j++).getStringCellValue().equals("choice4")
					&& row.getCell(j++).getStringCellValue().equals("hint")
					&& row.getCell(j++).getStringCellValue().equals("answer")
					&& row.getCell(j++).getStringCellValue()
						.equals("questionMarks")))
			{
				throw new ExcelDataImport(
					"error.invalid.file.format");
			}
			else if (i > 0)
			{

				TestPaperEntity testPaperEntity = new TestPaperEntity();

				testPaperEntity
					.setTestSeries(row.getCell(j++).getStringCellValue());
				testPaperEntity
					.setQuestion(row.getCell(j++).getStringCellValue());
				testPaperEntity
					.setChoice1(row.getCell(j++).getStringCellValue());
				testPaperEntity
					.setChoice2(row.getCell(j++).getStringCellValue());
				testPaperEntity
					.setChoice3(row.getCell(j++).getStringCellValue());
				testPaperEntity
					.setChoice4(row.getCell(j++).getStringCellValue());
				testPaperEntity.setHint(row.getCell(j++).getStringCellValue());
				testPaperEntity
					.setAnswer(row.getCell(j++).getStringCellValue());

				testPaperEntity.setQuestionMarks(
					(int) row.getCell(j++).getNumericCellValue());

				testPaperEntityList.add(testPaperEntity);
			}

		}
		questionsRepository.saveAll(testPaperEntityList);
	}

	public List<TestPaperEntity> getQuestionsBySeries(String testSeries)
	{
		return questionsRepository.getByTestSeries(testSeries);
	}
}