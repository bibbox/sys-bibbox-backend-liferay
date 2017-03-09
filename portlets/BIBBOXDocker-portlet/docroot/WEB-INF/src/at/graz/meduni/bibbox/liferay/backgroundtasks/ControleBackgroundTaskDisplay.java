package at.graz.meduni.bibbox.liferay.backgroundtasks;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.display.BaseBackgroundTaskDisplay;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.HtmlUtil;

public class ControleBackgroundTaskDisplay extends BaseBackgroundTaskDisplay {

	private static final String _DETIALS_TEMPLATE =
			"com/liferay/exportimport/background/task/display/dependencies" +
				"/export_import_background_task_details.ftl";
	
	public ControleBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		super(backgroundTask);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPercentage() {
		// TODO Auto-generated method stub
		return 42;
	}

	@Override
	protected TemplateResource getTemplateResource() {
		Class<?> clazz = getClass();

		ClassLoader classLoader = clazz.getClassLoader();

		return new URLTemplateResource(_DETIALS_TEMPLATE, classLoader.getResource(_DETIALS_TEMPLATE));
	}

	@Override
	protected Map<String, Object> getTemplateVars() {
		Map<String, Object> templateVars = new HashMap<>();
		templateVars.put("htmlUtil", HtmlUtil.getHtml());
		return templateVars;
	}

}
