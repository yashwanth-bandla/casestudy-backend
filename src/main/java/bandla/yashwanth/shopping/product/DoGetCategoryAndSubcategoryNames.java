package bandla.yashwanth.shopping.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoGetCategoryAndSubcategoryNames {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public List<List<String>> getCategoryAndSubcategoryNames() {
		List<List<String>> outputList = new ArrayList<List<String>>();
		outputList.add(categoryRepository.getAllCategoryNames());
		outputList.add(subCategoryRepository.getAllSubCategoryNames());

		return outputList;
	}
}
