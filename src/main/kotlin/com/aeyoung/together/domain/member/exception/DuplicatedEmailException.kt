import com.aeyoung.together.global.exception.BasicException
import com.aeyoung.together.global.exception.ErrorCode

class DuplicatedEmailException : BasicException(ErrorCode.DUPLICATE_EMAIL)