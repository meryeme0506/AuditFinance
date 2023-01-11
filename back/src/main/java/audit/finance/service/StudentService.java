package audit.finance.service;

import audit.finance.entity.Finance;
import audit.finance.entity.Student;
import audit.finance.repository.FinanceEntityRepository;
import lombok.AllArgsConstructor;
import audit.finance.api.dto.FinanceRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentEntityRepository studentEntityRepository;
    private final FinanceEntityRepository bookEntityRepository;


    public List<Student> getAll() {
        return studentEntityRepository.findAll();
    }

    @Transactional
    public Student save(Student s) {
        return studentEntityRepository.save(s);
    }

    @Transactional
    public Student save(Integer id, List<FinanceRequestDto> books) {
        Optional<Student> studentOptional = studentEntityRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return null;
        }
        Student student = studentOptional.get();
        List<Finance> listBook = new ArrayList<>();
        for (FinanceRequestDto book : books) {
            Finance bookEntity = bookEntityRepository.findByCode(book.getCode());
            if (bookEntity == null) {
                bookEntity = bookEntityRepository.save(new Finance(book.getCode(), book.getName()));
            }
            listBook.add(bookEntity);
        }
        student.setBooks(listBook);
        return studentEntityRepository.save(student);
    }

    public void delete(String email) {
        Optional<Student> student = studentEntityRepository.findByEmail(email);
        student.ifPresent(studentEntityRepository::delete);
    }

    public Student update(Student s, String email) {
        Optional<Student> studentOptional = studentEntityRepository.findById(s.getId());
        if (studentOptional.isEmpty()) {
            return null;
        }
        Student student = studentOptional.get();
        student.setEmail(email);
        return studentEntityRepository.save(student);
    }
}
