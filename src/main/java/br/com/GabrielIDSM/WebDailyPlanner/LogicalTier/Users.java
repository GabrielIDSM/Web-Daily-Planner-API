package br.com.GabrielIDSM.WebDailyPlanner.LogicalTier;

import br.com.GabrielIDSM.WebDailyPlanner.Model.UserModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.BirthdayRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.DayRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.EventIdRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.GenericRequestModel;
import br.com.GabrielIDSM.WebDailyPlanner.RequestModel.IdRequestModel;
import java.util.List;
import java.util.Objects;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class Users {

    private final static BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static boolean isUserWithEncoder(UserModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && PASSWORD_ENCODER.matches(user.getPassword(), u.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUserWithEncoder(IdRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && PASSWORD_ENCODER.matches(user.getPassword(), u.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUserWithEncoder(GenericRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && PASSWORD_ENCODER.matches(user.getPassword(), u.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUserWithEncoder(BirthdayRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && PASSWORD_ENCODER.matches(user.getPassword(), u.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUserWithEncoder(DayRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && PASSWORD_ENCODER.matches(user.getPassword(), u.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUserWithEncoder(EventIdRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && PASSWORD_ENCODER.matches(user.getPassword(), u.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUser(IdRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && Objects.equals(u.getPassword(), user.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUser(DayRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && Objects.equals(u.getPassword(), user.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUser(EventIdRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())
                        && Objects.equals(u.getPassword(), user.getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static UserModel getUser(IdRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static UserModel getUser(GenericRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static UserModel getUser(BirthdayRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static UserModel getUser(DayRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static UserModel getUser(EventIdRequestModel user, List<UserModel> users) {
        try {
            for (UserModel u : users) {
                if (Objects.equals(u.getEmail(), user.getEmail())) {
                    return u;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static UserModel newUser(UserModel user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()).replace("'", "''"));
        user.setName(user.getName().replace("'", "''"));
        user.setEmail(user.getEmail().replace("'", "''"));
        return user;
    }

}
