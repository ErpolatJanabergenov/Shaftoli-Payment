package uz.pdp.shaftoli.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.repository.transaction.TransactionRepository;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;
    @Override
    public TransactionEntity add(TransactionEntity transaction) {
        return null;
    }

    @Override
    public String addTransaction(TransactionEntity transaction) {
        return transactionRepository.saveTransaction(transaction);
    }

    @Override
    public ArrayList<TransactionEntity> getAll() {
        return null;
    }

    @Override
    public TransactionEntity getById() {
        return null;
    }
}
