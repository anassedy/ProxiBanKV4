package ma.jit.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GroupeF
 *
 */
@Aspect
@Component
public class TraceVirement {
	private static final Logger log = Logger.getRootLogger();

	/**
	 *  method sans param
	 */
	@Pointcut(value = "execution(* ma.jit.rest.CompteRest.virement(..) )")
	public void myPointcut() {

	}

	/** method avec param
	 * @param p
	 * @throws Throwable
	 */
	@After("myPointcut()")
	public void enregistrement(JoinPoint p) throws Throwable {
		SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
		String date = formatdate.format(new Date());
		Object[] param = p.getArgs();
		ObjectMapper obj = new ObjectMapper();
		String methodeName = p.getSignature().getName();
		System.out.println("enregistrement en cours");

		FileAppender file = null;
		try {
			file = new FileAppender();
			file.setLayout(new SimpleLayout());
			file.setFile("./virementlog.txt");
			file.activateOptions();
			log.addAppender(file);
			log.setLevel(Level.DEBUG);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info(date + " " + methodeName + " " + obj.writeValueAsString(param));

	}

}
