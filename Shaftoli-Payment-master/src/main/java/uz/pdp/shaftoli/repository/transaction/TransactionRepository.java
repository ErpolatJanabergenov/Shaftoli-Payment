package uz.pdp.shaftoli.repository.transaction;

import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends BaseRepository<TransactionEntity> {
    String saveTransaction(TransactionEntity trans);
    List<TransactionEntity> getByOwnerId (UUID id);
    List<TransactionEntity> allUserTransactions(UUID id);
}
