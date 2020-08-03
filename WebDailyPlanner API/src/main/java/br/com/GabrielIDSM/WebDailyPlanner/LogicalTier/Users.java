package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.DayRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.EventIdRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.IdRequestModel;
import java.util.List;
import java.util.Objects;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class Users {
    
    private final static BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    
    public static boolean isUserWithEncoder(UserModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())
                        && Objects.equals(u.getPassword(), PASSWORD_ENCODER.encode(usuario.getPassword()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isUserWithEncoder(IdRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())
                        && Objects.equals(u.getPassword(), PASSWORD_ENCODER.encode(usuario.getPassword()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isUserWithEncoder(DayRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())
                        && Objects.equals(u.getPassword(), PASSWORD_ENCODER.encode(usuario.getPassword()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isUserWithEncoder(EventIdRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())
                        && Objects.equals(u.getPassword(), PASSWORD_ENCODER.encode(usuario.getPassword()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isUser(IdRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())
                        && Objects.equals(u.getPassword(), usuario.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isUser(DayRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())
                        && Objects.equals(u.getPassword(), usuario.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean isUser(EventIdRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())
                        && Objects.equals(u.getPassword(), usuario.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static UserModel getUser(IdRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static UserModel getUser(DayRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static UserModel getUser(EventIdRequestModel usuario, List<UserModel> usuarios) {
        try {
            for (UserModel u : usuarios) {
                if (Objects.equals(u.getEmail(), usuario.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static UserModel newUser (UserModel user){
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        user.setName(user.getName().replace("'", "''"));
        user.setEmail(user.getEmail().replace("'", "''"));
        return user;
    }
    
}
