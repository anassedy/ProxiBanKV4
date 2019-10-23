package ma.jit.entites;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author GroupeF
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;


	private int active;

	private String roles = "";

	private String permissions = "";
	@OneToOne(cascade = CascadeType.ALL)
	private Employe employe;


	/** constructeur avec param
	 * @param username
	 * @param password
	 * @param roles
	 * @param permissions
	 */
	public User(String username, String password, String roles, String permissions){
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
		this.active = 1;
	}

	/**
	 *  constructeur sans param
	 */
	protected User(){}


	/**
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @return
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @return
	 */
	public String getPermissions() {
		return permissions;
	}

	/**
	 * @return
	 */
	public List<String> getRoleList(){
		if(this.roles.length() > 0){
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}

	/**
	 * @return
	 */
	public List<String> getPermissionList(){
		if(this.permissions.length() > 0){
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}

	/**
	 * @return
	 */
	public Employe getEmploye() {
		return employe;
	}

	/**
	 * @param employe
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
}
