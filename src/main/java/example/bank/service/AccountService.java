package example.bank.service;

import example.bank.exception.AccountLimitReachedException;
import example.bank.model.Account;
import example.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private static final int MAX_ACCOUNTS_PER_CUSTOMER = 5;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        List<Account> existingAccounts = accountRepository.findByCustomerName(account.getCustomerName());

        if (existingAccounts.size() >= MAX_ACCOUNTS_PER_CUSTOMER) {
            throw new AccountLimitReachedException("Maximum account limit reached for customer");
        }

        account.setAccountNumber(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }
}
