// LoginFragment.kt
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.skye.practicamostrarusuario.AuthViewModel
import com.skye.practicamostrarusuario.R
import com.skye.practicamostrarusuario.User
import com.skye.practicamostrarusuario.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: AuthViewModel


    // Simulando una lista de usuarios
    val users = listOf(
        User("admin", "123"),
        User("nere", "123")
        // Agrega más usuarios
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)



        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (viewModel.loginUser(username, password, users)) {
                showToast("Autenticación exitosa")

                val bundle = Bundle()
                bundle.putString("username", username)
                bundle.putString("password", password)

                // Usar Safe Args para pasar datos al siguiente fragmento

                Navigation.findNavController(it)
                    .navigate(R.id.action_loginFragment_to_mostrarFragment)


            } else {
                showToast("Autenticación NO exitosa")
            }
        }


    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
